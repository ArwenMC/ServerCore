# ServerCore
Why have 8 plugins, when you can have 1? Fully customisable. Fast. Easy to use.  
Everything is configurable within the `config.yml`. I like consistency throughout my server and that extends down to a no permission message and so a priority for me was allowing you to customize it as much as possible.  
If they are spelling mistakes then plesae let us know so we can get right on them, same goes for bugs. I did try and squish as many as possible.  
We are currently working on database support and we aim to get that out before version 2.0 but no promises; it is about finding a balance between information and speed because we don't want to slow down your server.  
## Permission System
ServerCore uses a slightly unusual permission system that instead of you having to lookup individual permission nodes you just set what group is allowed to use the command.  
| Group Name | Permission Node | Description                                        |
|------------|-----------------|----------------------------------------------------|
| Admin      | `sc.admin`      | The administrator group - the highest in the land. |
| Staff      | `sc.staff`      | The staff group, not as high access.               |
| Donator    | `sc.donator`    | Access to the fun commands!                        |
| Member     | `sc.member`     | A trusted a member of the community.               |
| Player     | `sc.player`     | Should be given to your default group.             |