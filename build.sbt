enablePlugins(org.nlogo.build.NetLogoExtension, org.nlogo.build.ExtensionDocumentationPlugin)

version := "1.1.1"

netLogoExtName      := "palette"

netLogoClassManager := "PaletteExtension"

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

netLogoZipSources   := false

javaSource in Compile := baseDirectory.value / "src"

javacOptions ++= Seq("-g", "-Xlint:deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path",
  "-encoding", "us-ascii")

netLogoVersion := "6.1.1-c82c397"
