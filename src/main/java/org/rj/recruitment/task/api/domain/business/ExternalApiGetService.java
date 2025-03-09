package org.rj.recruitment.task.api.domain.business;

import org.rj.recruitment.task.api.domain.model.RepositoriesUser;

public interface ExternalApiGetService {
    RepositoriesUser getRepositoriesForUser(String username);
}
