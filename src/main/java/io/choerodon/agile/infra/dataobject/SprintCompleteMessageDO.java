package io.choerodon.agile.infra.dataobject;

import java.util.List;

/**
 * Created by jian_zhang02@163.com on 2018/5/18.
 */
public class SprintCompleteMessageDO {
    private Integer incompleteIssues;
    private Integer partiallyCompleteIssues;
    private List<SprintNameDO> sprintNames;

    public Integer getIncompleteIssues() {
        return incompleteIssues;
    }

    public void setIncompleteIssues(Integer incompleteIssues) {
        this.incompleteIssues = incompleteIssues;
    }

    public Integer getPartiallyCompleteIssues() {
        return partiallyCompleteIssues;
    }

    public void setPartiallyCompleteIssues(Integer partiallyCompleteIssues) {
        this.partiallyCompleteIssues = partiallyCompleteIssues;
    }

    public List<SprintNameDO> getSprintNames() {
        return sprintNames;
    }

    public void setSprintNames(List<SprintNameDO> sprintNames) {
        this.sprintNames = sprintNames;
    }
}
