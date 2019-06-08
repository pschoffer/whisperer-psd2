package com.techsylvania.klarnauts.whisperer.data.domain;

import java.io.Serializable;
import java.util.Map;

public class ReportItem implements Serializable {
  private String label;
  private int percentage;
  private long value;
  private Map<String, String> attrbutes;

  public ReportItem(final String label, final int percentage, final long value, Map<String, String> attrbutes) {
    this.label = label;
    this.percentage = percentage;
    this.value = value;
    this.attrbutes = attrbutes;
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

  public Map<String, String> getAttrbutes() {
    return attrbutes;
  }
}
