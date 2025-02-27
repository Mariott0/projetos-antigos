import React from "react"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { ScrollArea } from "@/components/ui/scroll-area"
import { Search, Menu, Home, Compass, PlaySquare, Clock, ThumbsUp, User } from "lucide-react"

export default function YouTubeUI() {
  const sidebarItems = [
    { icon: Home, label: "Home" },
    { icon: Compass, label: "Explore" },
    { icon: PlaySquare, label: "Subscriptions" },
    { icon: Clock, label: "Library" },
    { icon: ThumbsUp, label: "Liked Videos" },
  ]

  const videos = [
    { id: 1, title: "Amazing Video 1", channel: "Channel 1", views: "1M views", timestamp: "2 days ago" },
    { id: 2, title: "Awesome Tutorial", channel: "Channel 2", views: "500K views", timestamp: "1 week ago" },
    { id: 3, title: "Funny Cats Compilation", channel: "Channel 3", views: "2M views", timestamp: "3 days ago" },
    { id: 4, title: "Tech Review 2023", channel: "Channel 4", views: "750K views", timestamp: "5 days ago" },
    { id: 5, title: "Travel Vlog: Paris", channel: "Channel 5", views: "1.5M views", timestamp: "1 month ago" },
    { id: 6, title: "Cooking Masterclass", channel: "Channel 6", views: "300K views", timestamp: "2 weeks ago" },
    { id: 7, title: "Fitness Workout Routine", channel: "Channel 7", views: "900K views", timestamp: "4 days ago" },
    { id: 8, title: "Music Cover: Popular Song", channel: "Channel 8", views: "1.2M views", timestamp: "1 week ago" },
  ]

  return (
    <div className="flex h-screen bg-background text-foreground">
      {/* Sidebar */}
      <aside className="w-64 bg-card text-card-foreground hidden md:block">
        <ScrollArea className="h-full">
          <div className="p-4 space-y-4">
            {sidebarItems.map((item, index) => (
              <Button key={index} variant="ghost" className="w-full justify-start">
                <item.icon className="mr-2 h-4 w-4" />
                {item.label}
              </Button>
            ))}
          </div>
        </ScrollArea>
      </aside>

      {/* Main Content */}
      <div className="flex-1 flex flex-col overflow-hidden">
        {/* Header */}
        <header className="bg-card text-card-foreground shadow-sm">
          <div className="flex items-center justify-between p-4">
            <div className="flex items-center">
              <Button variant="ghost" size="icon" className="mr-4 md:hidden">
                <Menu className="h-6 w-6" />
              </Button>
              <h1 className="text-xl font-bold">YouTube</h1>
            </div>
            <div className="flex-1 max-w-xl mx-4">
              <div className="relative">
                <Input type="search" placeholder="Search" className="w-full pl-10" />
                <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 h-4 w-4 text-muted-foreground" />
              </div>
            </div>
            <Button variant="ghost" size="icon">
              <User className="h-6 w-6" />
            </Button>
          </div>
        </header>

        {/* Video Grid */}
        <main className="flex-1 overflow-y-auto p-4">
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4">
            {videos.map((video) => (
              <div key={video.id} className="bg-card text-card-foreground rounded-lg overflow-hidden shadow-sm">
                <img
                  src={`/placeholder.svg?height=180&width=320&text=Video+${video.id}`}
                  alt={video.title}
                  className="w-full h-48 object-cover"
                />
                <div className="p-4">
                  <h3 className="font-semibold truncate">{video.title}</h3>
                  <p className="text-sm text-muted-foreground">{video.channel}</p>
                  <p className="text-xs text-muted-foreground">
                    {video.views} • {video.timestamp}
                  </p>
                </div>
              </div>
            ))}
          </div>
        </main>
      </div>
    </div>
  )
}