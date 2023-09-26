package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // Get average grade for all students in your team.
        Team currentTeam = this.gradeDB.getMyTeam();
        String[] members = currentTeam.getMembers();
        float totalTeamGrade = 0.0f;
        for (int i = 0; i < members.length; i++) {
            Grade g = this.gradeDB.getGrade(members[i], course);
            totalTeamGrade += g.getGrade();
        }
        return totalTeamGrade / members.length;
    }
}
