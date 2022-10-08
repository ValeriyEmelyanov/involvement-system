package com.example.involvementsystem.service.Impl;

import com.example.involvementsystem.dto.MemberPageRequest;
import com.example.involvementsystem.dto.MemberRatingPageResponse;
import com.example.involvementsystem.dto.MemberRatingResponse;
import com.example.involvementsystem.dto.MemberResponse;
import com.example.involvementsystem.model.User;
import com.example.involvementsystem.projection.MemberRatingView;
import com.example.involvementsystem.repository.UserRepository;
import com.example.involvementsystem.repository.specification.UserSpecification;
import com.example.involvementsystem.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final UserRepository userRepository;

    private final ConversionService conversionService;

    @Override
    public List<MemberRatingResponse> getTop() {
        List<MemberRatingView> top = userRepository.findTop();
        return top.stream()
                .map(u -> conversionService.convert(u, MemberRatingResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public MemberRatingPageResponse getAll(MemberPageRequest request) {

        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(),
                Sort.by(Sort.Direction.DESC, "rating.sum"));

        Specification<User> specification = buildUserSpecification(request);

        Page<User> page = specification == null ?
                userRepository.findAll(pageable) :
                userRepository.findAll(specification, pageable);

        List<MemberRatingResponse> memberResponseList = page.getContent().stream()
                .map(u -> conversionService.convert(u, MemberRatingResponse.class))
                .collect(Collectors.toList());

        return MemberRatingPageResponse.builder()
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalItems(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .content(memberResponseList)
                .build();
    }

    private static Specification<User> buildUserSpecification(MemberPageRequest request) {
        Specification<User> specification = null;

        if (request.getFullName() != null && !request.getFullName().isBlank()) {
            specification = UserSpecification.like("fullName", request.getFullName());
        }

        if (request.getDepartment() != null) {
            specification = specification == null ?
                    UserSpecification.equal(request.getDepartment()) :
                    specification.and(UserSpecification.equal(request.getDepartment()));
        }

        if (request.getPosition() != null) {
            specification = specification == null ?
                    UserSpecification.equal(request.getPosition()) :
                    specification.and(UserSpecification.equal(request.getPosition()));
        }

        if (request.getGuild() != null) {
            specification = specification == null ?
                    UserSpecification.equal(request.getGuild()) :
                    specification.and(UserSpecification.equal(request.getGuild()));
        }

        if (request.getLevel() != null) {
            specification = specification == null ?
                    UserSpecification.equal(request.getLevel()) :
                    specification.and(UserSpecification.equal(request.getLevel()));
        }
        return specification;
    }

    @Override
    public MemberResponse getById(Long memberId) {
        return conversionService.convert(
                userRepository.findById(memberId).orElseThrow(RuntimeException::new), MemberResponse.class);
    }
}
