package com.library.Library.repository;

import com.library.Library.entity.AppUser;
import com.library.Library.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderDetail, String> {
    Optional<OrderDetail> findOrderDetailByAppUser(AppUser appUser);
    Optional<OrderDetail> findOrderDetailByAppUserAndIsPaid(AppUser appUser, Boolean isPaid);
}
