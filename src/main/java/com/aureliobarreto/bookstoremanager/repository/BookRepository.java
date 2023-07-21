package com.aureliobarreto.bookstoremanager.repository;
import com.aureliobarreto.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book , Long> {

}
