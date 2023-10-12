import prisma from "@/prisma/client";
import { redirect } from "next/navigation";
import { NextResponse } from "next/server";

export async function GET(req: Request) {
  const username = localStorage.getItem("username");
  const secret = localStorage.getItem("secret");
  if (!username || !secret) {
    redirect("/");
  }
  const data = await prisma.scores.findMany({
    where: { username: username, secret: secret },
    take: 10,
    orderBy: { created: "desc" },
    select: {
      id: true,
      created: true,
      green_score: true,
      red_score: true,
      username:true
    },
  });
  if (!data) return NextResponse.json("No data found");
  const schemadata = data.map((item) => ({
    id: item.id,
    red_score: item.red_score,
    username:item.username,
    green_score: item.green_score,
    date: item.created?.toLocaleDateString(),
  }));
  return NextResponse.json(schemadata);
}
