package org.saliam.smartbids.item.presentation.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.saliam.smartbids.item.domain.entity.Period;
import org.saliam.smartbids.user.domain.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class ItemCreateDto
{
  @NotBlank
  private String name;

  @NotNull
  private Long ownerId;

  @NotNull
  private Period duration;

  @NotEmpty
  private String minimumPrize;
}
