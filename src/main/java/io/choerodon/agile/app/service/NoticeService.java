package io.choerodon.agile.app.service;

import io.choerodon.agile.api.dto.MessageDTO;
import io.choerodon.agile.domain.agile.entity.IssueE;

import java.util.List;

public interface NoticeService {

    List<MessageDTO> queryByProjectId(Long projectId);

    void updateNotice(Long projectId, List<MessageDTO> messageDTOList);

    List<Long> queryUserIdsByProjectId(Long projectId, String event, IssueE issueE);
}