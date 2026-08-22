package com.moive.MoiveBE.domain.user.repository;

import com.moive.MoiveBE.domain.user.entity.User;
import com.moive.MoiveBE.domain.user.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKakaoMemberIdAndStatus(
            Long kakaoMemberId,
            UserStatus status
    );
}