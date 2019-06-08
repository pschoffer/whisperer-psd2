package com.techsylvania.klarnauts.whisperer.data.domain;

import java.io.Serializable;

public class ReportItem implements Serializable {
  private String label;
  private int percentage;
  private long value;

  public ReportItem(final String label, final int percentage, final long value) {
    this.label = label;
    this.percentage = percentage;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public int getPercentage() {
    return percentage;
  }

  public long getValue() {
    return value;
  }
}
