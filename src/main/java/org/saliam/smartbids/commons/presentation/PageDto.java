package org.saliam.smartbids.commons.presentation;

import java.util.Iterator;
import java.util.List;

public class PageDto<T extends PageableDto> implements Iterable<T> {
  private List<T> content;
  private long totalElements;
  private int pageNumber;

  public PageDto() {
    this(null, 0, 0);
  }

  public PageDto(List<T> content, int pageNumber, long totalElements) {
    setContent(content);
    setTotalElements(totalElements);
    setPageNumber(pageNumber);
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

  public long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(long totalElements) {
    this.totalElements = totalElements;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  @Override
  public Iterator<T> iterator() {
    return content.iterator();
  }
}
