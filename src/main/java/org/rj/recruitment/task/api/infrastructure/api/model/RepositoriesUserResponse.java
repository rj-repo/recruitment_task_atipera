package org.rj.recruitment.task.api.infrastructure.api.model;

import lombok.*;
import org.rj.recruitment.task.api.domain.model.RepositoriesUser;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RepositoriesUserResponse {
    private String username;
    private List<RepositoryUserResponse> repositoryUserList;

    public static RepositoriesUserResponse of(RepositoriesUser user) {
        return RepositoriesUserResponse.builder()
                .username(user.getUsername())
                .repositoryUserList(user.getRepositoryUserList().stream().map(RepositoryUserResponse::of).collect(Collectors.toList()))
                .build();
    }
}
