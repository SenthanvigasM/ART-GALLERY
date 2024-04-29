package com.onlinenotesharing.repository;

import com.onlinenotesharing.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
