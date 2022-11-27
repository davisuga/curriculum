package render_cv;

def renderTopic(description: String) =
  s"""
  <li style="list-style-type: disc">
    ${description}
  </li>
  """

def workExperience(workXp: generated_types.WorkExperiences) =
  s"""
       <h3 id="97f6e1f4-14a9-4a3f-a3c5-53966fc22fd8" class="">
          ${workXp.title} | ${workXp.place}
        </h3>
        <p id="27384f98-d226-47e3-854e-b2e029e54ae5" class="">
          ${workXp.startDate} - ${workXp.endDate}
        </p>
        <ul id="3ce93bf0-2722-4d3a-988f-33bb07da4f71" class="bulleted-list">
         ${workXp.achievements.map(renderTopic).toList.reduce((_ + _))}
        </ul>
        """

def academicXp(academicXp: generated_types.AcademicExperiences) =
  s"""
       <h3 id="97f6e1f4-14a9-4a3f-a3c5-53966fc22fd8" class="">
          ${academicXp.title} | ${academicXp.place}
        </h3>
        <p id="27384f98-d226-47e3-854e-b2e029e54ae5" class="">
          ${academicXp.startDate} - ${academicXp.endDate}
        </p>
        <ul id="3ce93bf0-2722-4d3a-988f-33bb07da4f71" class="bulleted-list">
         ${academicXp.achievements.map(renderTopic).toList.reduce((_ + _))}
        </ul>
        """

def renderFromCV(css: String, cvData: generated_types.RootInterface) = s"""
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Davi Suga</title>
    <link rel="stylesheet" href="base.css" />
    <style>$css</style>
  </head>
  <body>
    <article id="5e8cf6b6-64d7-4b80-a471-82d217582ef5" class="page sans">
      <header><h1 class="page-title">Davi Suga</h1></header>
      <div class="page-body">
        <div id="9d21a44b-6e04-47d8-853f-9746384d4665" class="column-list">
          <div
            id="fd641859-d87d-4766-b0e3-9db2e96eb8da"
            style="width: 31.25%"
            class="column"
          >
            <h2 id="1f4316c4-4b1f-42f6-95c3-4ec919e0037c" class="">
              ${cvData.subtitle}
            </h2>
            <p id="35b936d2-68ed-42a6-8b75-5a10f726db55" class="">
              <a href="${cvData.github}">${cvData.github} </a
              ><a href="${cvData.linkedin}"
                >${cvData.linkedin}</a
              >
              <a href="mailto:${cvData.email}">${cvData.email}</a>
            </p>
          </div>
          <div
            id="8304ba19-c33a-412c-a889-3813d9183362"
            style="width: 68.75%"
            class="column"
          >
            <p id="bcd39ea6-826b-42c1-bd6c-a1c5c0dc6f6d" class="bio">
            ${cvData.bio}
            </p>
          </div>
        </div>
        <h2 id="7cf8d286-a176-4c62-8356-4a0f5e554a06" class="">
          WORK EXPERIENCE
        </h2>
        ${cvData.workExperiences.map(workExperience).reduce(_ + _)}
       
     
        <h2 id="bc753107-3c67-42d4-ad75-d6e2aa0a34ea" class="">
          ACADEMIC EXPERIENCES
        </h2>
          ${cvData.academicExperiences.map(academicXp).reduce(_ + _)}
        <p id="68c7dade-e764-4ac6-bcbb-1f350203fe1a" class=""></p>
      </div>
    </article>
  </body>
</html>

"""
