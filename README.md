# status-server
Check to see if given servers are alive by running HTTP requests.

# Configuration
Specify servers by editing `url` line in `conf/application.conf`

# Running

    $ play run

Or by generating the distribution:

    $ play dist
    # extract target/universal/status-server-$version.zip and cd $dir
    $ bin/status-server

## Further Resources

 * Homepage:   https://github.com/mbezjak/status-server
 * Issues:     https://github.com/mbezjak/status-server/issues
 * Changelog:  see Changelog.md file
 * Roadmap:    see Roadmap.md file
 * License:    MIT (see LICENSE file)
