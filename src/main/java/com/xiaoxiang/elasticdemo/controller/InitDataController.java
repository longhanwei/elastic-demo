package com.xiaoxiang.elasticdemo.controller;

import com.xiaoxiang.elasticdemo.entity.Book;
import com.xiaoxiang.elasticdemo.entity.BookEntity;
import com.xiaoxiang.elasticdemo.repository.BookEntityRepository;
import com.xiaoxiang.elasticdemo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lhw<br>
 * @version 1.0<br>
 * @Description <Description> <br>
 * @taskId: <br>
 * @createDate 2019/11/13 11:30 <br>
 * @see com.xiaoxiang.elasticdemo.controller <br>
 */
@RestController
@RequestMapping("int")
public class InitDataController {
	Logger log = LoggerFactory.getLogger(InitDataController.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookEntityRepository bookEntityRepository;
	@PostMapping("data")
	public String  initData(String type){
		if ("true".equals(type)){
			String[]ye ={"2018","2019"};
			String[]ge ={"一年级","二年纪","三年纪","四年纪","五年纪","六年纪","七年纪","八年纪","九年纪","高一","高二","高三"};
			String[]tie={"上册","下册"};
			String[]per={"牛津版","卢教版","人教版","北师大版","广东经济出版社"};
			String[]op={"语文","数学","英语","物理","历史","生物","化学","地理","道德与法治","科学"};
			String[]d={"活动手册","知识与能力训练","单元训练","课本答案","练习册","试卷","报纸答案"};
			for (int i = 0; i <10 ; i++) {
				new Thread("no"+i) {
					@Override
					public void run() {
						for (int i = 0; i < 300; i++) {
							System.out.println("Thread: " + this.getName() + " Running");
							StringBuffer title = new StringBuffer();
							int yeindex = (int) (Math.random() * ye.length);
							title.append(ye[yeindex]);
							int geindex = (int) (Math.random() * ge.length);
							title.append(ge[geindex]);
							int tieindex = (int) (Math.random() * tie.length);
							title.append(tie[tieindex]);
							int perindex = (int) (Math.random() * per.length);
							title.append(per[perindex]);
							int opindex = (int) (Math.random() * op.length);
							title.append(op[opindex]);
							int dindex = (int) (Math.random() * d.length);
							title.append(d[dindex]);
							String name = title.toString();
							log.info("name=" + name);
							String bookId= UUID.randomUUID().toString();
							BookEntity save=new BookEntity();
							Book bookes=new Book();
							save.setBookId(bookId);
							save.setTitle(name);
							bookes.setBookName(name);
							bookes.setBookId(bookId);
							bookEntityRepository.save(save);
							bookRepository.save(bookes);



						}
					}
					}.start();
			}
			return "ok";
		}
		return "no";
	}
	@GetMapping("save")
	public String save(BookEntity bookEntity){

		BookEntity save = bookEntityRepository.save(bookEntity);
		log.info("book="+save);
		return "ok";
	}

}
