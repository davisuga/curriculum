let h = (n, s) =>
  switch n {
  | 1 => <h1> {s->React.string} </h1>
  | 2 => <h2> {s->React.string} </h2>
  | 3 => <h3> {s->React.string} </h3>
  | 4 => <h4> {s->React.string} </h4>
  | _ => <div> {s->React.string} </div>
  }

let h1 = h(1)
let h2 = h(2)
let h3 = h(3)
let p = s => <> {s->React.string} </>
let li = s => <li> {s->React.string} </li>
let pipe = (a, b) =>
  <div>
    {a}
    {React.string(" | ")}
    {b}
  </div>
let empty = <> </>
let breakLine = <div className="separator" />
let combine = (a, b) => [a, b]->React.array
let link = (~name=?, source: string) =>
  <a href=source> {name->Belt.Option.getWithDefault(source)->React.string} </a>
let renderer: Cv.renderer<React.element> = {
  h1,
  h2,
  h3,
  p,
  li,
  pipe,
  empty,
  breakLine,
  combine,
  link,
}
let makeCurriculum = Cv.makeCurriculum(renderer)
