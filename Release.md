Release steps:

1. Add `Changelog.md` entry
2. Update version in `project/Build.scala`
3. Git work:

        $ git tag --annotate $version
        $ git push
        $ git push --tags
