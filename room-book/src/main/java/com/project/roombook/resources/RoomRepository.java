package com.project.roombook.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.roombook.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
