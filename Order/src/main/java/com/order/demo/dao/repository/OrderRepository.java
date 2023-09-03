package com.order.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.demo.dao.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
