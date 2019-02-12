package com.xr.base.core.page;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 分页信息
 * Created by forvoyager@outlook.com on 2019-01-31 13:23.
 */
public class Page<T> {

  private static final long serialVersionUID = 166L;

  /**
   * 总记录数
   */
  private int totalRecord;

  /**
   * 每页显示条数，默认 10
   */
  private int size = 10;

  /**
   * 总页数
   */
  private int totalPage;

  /**
   * 当前页（默认显示第1页）
   */
  private int page = 1;

  /**
   * 查询数据列表
   */
  private List<T> records = Collections.EMPTY_LIST;

  /**
   * 查询参数
   */
  private Map<String, Object> condition;

  public int getTotalRecord() {
    return totalRecord;
  }

  public void setTotalRecord(int totalRecord) {
    this.totalRecord = totalRecord;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public List<T> getRecords() {
    return records;
  }

  public void setRecords(List<T> records) {
    this.records = records;
  }

  public Map<String, Object> getCondition() {
    return condition;
  }

  public void setCondition(Map<String, Object> condition) {
    this.condition = condition;
  }
}
