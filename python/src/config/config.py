import os

from dotenv import load_dotenv

load_dotenv()

TOKEN = os.environ.get("TOKEN", "")
CHANNEL_ID = int(os.environ.get("CHANNEL_ID", ""))
