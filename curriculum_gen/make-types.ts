import transform from "npm:transform-json-types@*";

const encoder = new TextEncoder();

const json = await Deno.readTextFile("./me.json");

const result = transform(json, {
  lang: "scala",
});

console.log("Successfully generated types");
const namespace = "generated_types";
const header = `package ${namespace}`;
Deno.writeFile(
  "./src/main/scala/generated/GeneratedTypes.scala",
  encoder.encode(header.concat(result))
);
