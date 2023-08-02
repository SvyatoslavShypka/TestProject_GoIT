package com.goit.finalproject.note;

import com.goit.finalproject.access.Access;
import com.goit.finalproject.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 100, min = 5)
    private String title;

    @Length(max = 10000, min = 5)
    private String content;

    @Enumerated(EnumType.STRING)
    private Access access;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id") //TODO added nullable=false (, nullable = false)
    private User user;
}
