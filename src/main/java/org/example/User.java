package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private long chatId;
    private String fullName;
    private String username;
    private BotState state;

}
