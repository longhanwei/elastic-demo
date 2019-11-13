package com.xiaoxiang.elasticdemo.repository;



import com.xiaoxiang.elasticdemo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookRepository extends ElasticsearchRepository<Book, Integer>{

    List<Book> findByBookNameLike(String bookName);

    /**
     *
     * @param
     * @param pageable
     * @return
     */
    Page<Book> findByBookName(String bookName, Pageable pageable);

}

