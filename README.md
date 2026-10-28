# HomeWork-2

HomeWork 4 | CISC3130 | Ali Nofal











|**Method**|**Structures it touches**|**Big-O**|**One-line reason**|
|-|-|-|-|
|addSong|library, playlist, playcounts|||
|findSong|library|||
|play|library, history|||
|queueLater|library, upNext|||
|queueNext|library, upNext|||
|next|upNext, playlist, library, history|||
|back |history, library|||
|removeSong|library, playlist, playcounts|||
|showPlaylist|playlist|||







1. HashMap : Used for the songs library because each song has a special id, which makes the player find a song quickly instead searching through every song

2. ArrayDeque : Used for upNext queue beacuse it supports adding and removing songs from the back or the front of the queue



