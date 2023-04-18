package curriculum;

def renderMarkdown(rootInterface: generated_types.RootInterface) =
  val header = s"""# ${rootInterface.name}
                  |## ${rootInterface.subtitle}
                  |**Email:** ${rootInterface.email}
                  |**GitHub:** ${rootInterface.github}
                  |**LinkedIn:** ${rootInterface.linkedin}
                  |
                  |## Bio
                  |${rootInterface.bio}
                  |""".stripMargin

  val workExperiences = rootInterface.workExperiences
    .map { workExperience =>
      s"""### ${workExperience.title}
         |**${workExperience.place}** (${workExperience.startDate} - ${workExperience.endDate})
         |${workExperience.placeDescription}
         |
         |#### Achievements
         |${workExperience.achievements
          .map(achievement => s"* $achievement")
          .mkString("\n")}
         |
         |""".stripMargin
    }
    .mkString("\n")

  val academicExperiences = rootInterface.academicExperiences
    .map { academicExperience =>
      s"""### ${academicExperience.title}
         |**${academicExperience.place}** (${academicExperience.startDate} - ${academicExperience.endDate})
         |
         |#### Achievements
         |${academicExperience.achievements
          .map(achievement => s"* $achievement")
          .mkString("\n")}
         |""".stripMargin
    }
    .mkString("\n")

  s"""$header
       |## Work Experiences
       |$workExperiences
       |
       |## Academic Experiences
       |$academicExperiences
       |""".stripMargin
