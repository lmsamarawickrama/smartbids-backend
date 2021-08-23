package org.saliam.smartbids.bid.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class BidCreateDto
{
  @NotBlank
  private String itemId;

  @NotBlank
  private String bidderId;

  @NotBlank
  private String amount;
}
