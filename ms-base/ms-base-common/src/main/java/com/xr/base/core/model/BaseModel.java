package com.xr.base.core.model;

import java.io.Serializable;

/**
 * Created by forvoyager@outlook.com on 2019-02-01 11:34.
 */
public class BaseModel implements Serializable {

  protected Long create_time;
  protected Long update_time;
  protected Integer version;
  protected Integer where_version;

  public Long getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Long create_time) {
    this.create_time = create_time;
  }

  public Long getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(Long update_time) {
    this.update_time = update_time;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Integer getWhere_version() {
    return where_version;
  }

  public void setWhere_version(Integer where_version) {
    this.where_version = where_version;
  }
}
