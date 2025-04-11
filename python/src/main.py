import discord

from config.config import CHANNEL_ID, TOKEN

intents = discord.Intents.default()
client = discord.Client(intents=intents)


@client.event
async def on_ready():
  print("login successfully")
  game = discord.Game("Python")
  await client.change_presence(status=discord.Status.online, activity=game)

  embed = discord.Embed(description="test")
  channel = client.get_channel(CHANNEL_ID)
  if channel and isinstance(channel, discord.TextChannel):
    await channel.send(embed=embed)
  else:
    print(f"Error: Channel with ID {CHANNEL_ID} not found or is not a text channel.")


client.run(TOKEN)
