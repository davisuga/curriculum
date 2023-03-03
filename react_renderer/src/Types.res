type workExperience = {
  title: string,
  place: string,
  startDate: string,
  endDate: string,
  placeDescription: string,
  achievements: array<string>,
  tags: array<string>,
}
type academicExperience = {
  title: string,
  place: string,
  startDate: string,
  endDate: string,
  achievements: array<string>,
}
type me = {
  name: string,
  subtitle: string,
  email: string,
  github: string,
  linkedin: string,
  bio: string,
  workExperiences: array<workExperience>,
  academicExperiences: array<academicExperience>,
}
