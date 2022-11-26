package generated_types;
case class AcademicExperiences(
    title: String,
    place: String,
    startDate: String,
    endDate: String,
    achievements: Seq[String]
)

case class RootInterface(
    name: String,
    subtitle: String,
    email: String,
    github: String,
    linkedin: String,
    bio: String,
    workExperiences: Seq[WorkExperiences],
    academicExperiences: Seq[AcademicExperiences]
)

case class WorkExperiences(
    title: String,
    place: String,
    startDate: String,
    endDate: String,
    placeDescription: String,
    achievements: Seq[String],
    tags: Seq[String]
)
