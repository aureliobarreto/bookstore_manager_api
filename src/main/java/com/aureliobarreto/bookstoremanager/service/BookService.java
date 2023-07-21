package com.aureliobarreto.bookstoremanager.service;

import com.aureliobarreto.bookstoremanager.dto.BookDTO;
import com.aureliobarreto.bookstoremanager.exception.BookNotFoundException;
import com.aureliobarreto.bookstoremanager.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aureliobarreto.bookstoremanager.dto.MessageResponseDTO;
import com.aureliobarreto.bookstoremanager.entity.Book;
import com.aureliobarreto.bookstoremanager.repository.BookRepository;

import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;
    @Autowired
    public BookService (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDto) {
        Book bookToSave = bookMapper.toModel(bookDto);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID "+ savedBook.getId())
                .build();
    }

    public BookDTO findById (Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
