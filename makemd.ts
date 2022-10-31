import file from "./me.json" assert { type: "json" };
import { makeCurriculum } from "./renderer/src/Cv.bs";

const h = (n: number) => (s: string) => `${"#".repeat(n)} ${s}`;
const h1 = h(1);
const h2 = h(2);
const h3 = h(3);

const p = (s: string) => s;
const li = (s: string) => `- ${s}`;
const pipe = (a: string) => (b: string) => `${a} | ${b}`;

type formatter = {
  h1: (s: string) => string;
  h2: (s: string) => string;
  h3: (s: string) => string;
  li: (s: string) => string;
  p: (s: string) => string;
  pipe: (a: string) => (b: string) => string;
};

const mdFormatter: formatter = {
  h1,
  h2,
  h3,
  li,
  p,
  pipe,
};
makeCurriculum;
const makeCurriculum_ =
  ({ h1, h2, h3, li, p, pipe }: formatter) =>
  (f: typeof file) =>
    [
      h1(f.name),
      h2(f.subtitle),
      pipe(f.github)(f.linkedin),
      p(f.bio),
      h2("WORK EXPERIENCE"),
      f.workExperiences
        .flatMap((we) => [
          h3(`${we.title} at ${we.place} `),
          p(we.startDate + ` - ${we.endDate || "now"}`),
          we.achievements.map(li).join("\n\n"),
        ])
        .join("\n\n"),
      f.academicExperiences
        .flatMap((we) => [
          h3(`${we.title} at ${we.place} `),
          p(we.startDate + `- ${we.endDate || "now"}`),
          we.achievements.map(li).join("\n\n"),
        ])
        .join("\n\n"),
    ].join("\n\n");

console.log(makeCurriculum(mdFormatter)(file));
