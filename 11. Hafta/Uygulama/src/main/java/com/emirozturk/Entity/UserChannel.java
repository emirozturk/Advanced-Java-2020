package com.emirozturk.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User_channel")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@DynamicUpdate
@RequiredArgsConstructor
@NoArgsConstructor
public class UserChannel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name="userid",referencedColumnName = "id")
  @NonNull
  private User user;

  @ManyToOne
  @JoinColumn(name="channelid",referencedColumnName = "id")
  @NonNull
  private Channel channel;

  @Column(name = "auth")
  @NotNull
  @NonNull
  private long auth;

  @Column(name = "joindate")
  @NotNull
  @NonNull
  private java.sql.Date joindate;
}
