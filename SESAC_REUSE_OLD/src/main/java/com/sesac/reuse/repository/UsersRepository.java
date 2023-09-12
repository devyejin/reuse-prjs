package com.sesac.reuse.repository;

import com.sesac.reuse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

    public Users findByEmail(String email);

    public boolean existsByEmail(String email);
}
