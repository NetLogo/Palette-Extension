import org.nlogo.build.{ NetLogoExtension, ExtensionDocumentationPlugin }

enablePlugins(NetLogoExtension, ExtensionDocumentationPlugin)

name       := "palette"
version    := "2.1.0"
isSnapshot := true

netLogoVersion      := "7.0.0-beta2-7e8f7a4"
netLogoClassManager := "PaletteExtension"

Compile / javaSource := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-Xlint:deprecation", "-encoding", "us-ascii", "--release", "11")

scalaVersion := "3.7.0"
Test / scalaSource := baseDirectory.value / "src" / "test"
scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-feature", "-encoding", "us-ascii", "-release", "11")
