@genType
type renderer<'output> = {
  h1: string => 'output,
  h2: string => 'output,
  h3: string => 'output,
  p: string => 'output,
  li: string => 'output,
  pipe: ('output, 'output) => 'output,
  //   join: (array<'output>, 'output) => 'output,
  breakLine: 'output,
  combine: ('output, 'output) => 'output,
  empty: 'output,
  link: (~name: string=?, string) => 'output,
}
open Belt

@genType
let makeCurriculum = ({h1, h2, h3, li, p, pipe, combine, breakLine, empty, link}, f: Types.me) => {
  let addNewLine = x => combine(x, breakLine)
  let joinWithLn = a => Array.reduce(a, empty, (a, b) => combine(addNewLine(a), b))

  open Array
  [
    h1(f.name),
    h2(f.subtitle),
    pipe(link(f.github), link(f.linkedin)),
    p(f.bio),
    h2("WORK EXPERIENCE"),
    f.workExperiences
    ->flatMap(we => [
      h3(`${we.title} at ${we.place} `),
      p(`${we.startDate} - ${we.endDate}`),
      we.achievements->map(li)->joinWithLn,
    ])
    ->joinWithLn,
    f.academicExperiences
    ->flatMap(we => [
      h3(`${we.title} at ${we.place} `),
      p(`${we.startDate} - ${we.endDate}`),
      we.achievements->map(li)->joinWithLn,
    ])
    ->joinWithLn,
  ]->joinWithLn
}
