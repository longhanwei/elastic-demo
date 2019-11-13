package com.xiaoxiang.elasticdemo.repository;

import com.xiaoxiang.elasticdemo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lhw<br>
 * @version 1.0<br>
 * @Description <Description> <br>
 * @taskId: <br>
 * @createDate 2019/11/13 15:01 <br>
 * @see com.xiaoxiang.elasticdemo.repository <br>
 */
@Component
public interface BookEntityRepository extends JpaRepository<BookEntity,Integer> {

	List<BookEntity> findByTitleLike(String title);

}
