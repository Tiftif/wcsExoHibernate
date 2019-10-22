package com.wcs.heroSpring.heroSpring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wcs.heroSpring.heroSpring.entities.Hero;

@Repository
public interface HeroDao extends JpaRepository<Hero, Long> {
}