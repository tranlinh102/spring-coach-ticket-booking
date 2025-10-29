package com.coachticketbooking.coach.model.entity;

import com.coachticketbooking.common.id.GeneratedUuidV7;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "provinces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Province {

    @Id
    @GeneratedUuidV7
    private UUID id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "country_id", nullable = false)
//    private Country country;

    @Column(length = 20, unique = true)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

//    @Column(length = 50)
//    private String type; // "Tỉnh" hoặc "Thành phố"

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ward> wards;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean active = true;

    public Province(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

