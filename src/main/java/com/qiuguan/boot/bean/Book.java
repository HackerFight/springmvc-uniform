package com.qiuguan.boot.bean;

import lombok.Data;

/**
 * @author qiuguan
 * @date 2022/09/17 00:23:54  星期六
 *
 * 一个VO对象在新增的时候某些字段为必填，在更新的时候又非必填。如Book中 id 和 bookId 属性在新增操作时都是非必填(后端生成)
 * 而在编辑操作时都为必填，bookName在新增操作时为必填，面对这种场景你会怎么处理呢？
 */
@Data
public class Book {

    private Long id;

    private Long bookId;

    private String bookName;
}
