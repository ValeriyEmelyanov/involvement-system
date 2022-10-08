package com.example.involvementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "guild_info")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GuildInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GuildInfo guildInfo = (GuildInfo) o;
        return id != null && Objects.equals(id, guildInfo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
