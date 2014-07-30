This is GeeMod.

Make sure gradle is installed

run 'gradle setupDecompWorkspace' (or 'gradle setupDevWorkspace' to create without source)
run 'gradle --refresh-dependencies eclipse'

import project into eclipse

To launch the client (gradle):
1. type 'gradle runClient'

To launch the client (eclipse) (you may need to run gradle runClient once first to download additional libraries if you do not have the gradle plugin installed in eclipse):
1. Create new 'Run as' Java application
2. Select your project
3. In the Main class, type: 'GradleStart'
4. On the Arguments tab, in the 'VM arguments': '-Xincgc -Xmx1024M -Xms1024M'
5. Working directory: '${workspace_loc}'
6. Save and run

To launch the server (gradle):
1. Type 'gradle runServer'

To launch the server (eclipse):
1. Create new 'Run as' Java application
2. Select your project
3. In the Main class, type: 'GradleStartServer'
4. On the Arguments tab, in the 'VM arguments': '-Xincgc -Xmx1024M -Xms1024M'
5. Working directory: '${workspace_loc}'
6. Save and run