let h = (n, s) => `${"#"->Js.String2.repeat(n)} ${s}`
let h1 = h(1)
let h2 = h(2)
let h3 = h(3)
let p = s => s
let li = s => `- ${s}`
let pipe = (a, b) => `${a} | ${b}`
let combine = (a, b) => String.concat(a, list{b})
let empty = ""
let breakLine = "\n\n"
let link = (~name=?, source: string) => `(${name->Belt.Option.getWithDefault(source)})[${source}]`

let renderer: Cv.renderer<string> = {
  h1,
  h2,
  h3,
  p,
  li,
  pipe,
  combine,
  breakLine,
  empty,
  link,
}
