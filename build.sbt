scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Ywarn-dead-code",
  "-Xlint",
  "-Xfatal-warnings"
)

lazy val root = project.in(file("."))
  .settings(tutSettings)

tutSourceDirectory := sourceDirectory.value / "raw"

tutTargetDirectory := sourceDirectory.value / "pages"

lazy val pdf = taskKey[Unit]("Build the PDF version of the book")
lazy val html = taskKey[Unit]("Build the HTML version of the book")
lazy val epub = taskKey[Unit]("Build the ePUB version of the book")
lazy val all = taskKey[Unit]("Build all versions of the book")

pdf := {
  val a = tut.value
  "grunt pdf" !
}

html := {
  val a = tut.value
  "grunt html" !
}

epub := {
  val a = tut.value
  "grunt epub" !
}


all := {
  val a = tut.value
  "grunt all" !
}
