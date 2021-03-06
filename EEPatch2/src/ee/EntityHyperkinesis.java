/*jadclipse*/// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) radix(10) lradix(10) 
// Source File Name:   EntityHyperkinesis.java

package ee;

import java.util.List;
import java.util.Random;
import net.minecraft.server.*;

// Referenced classes of package ee:
//            EEBase, Combustion

public class EntityHyperkinesis extends Entity
{

    public EntityHyperkinesis(World var1)
    {
        super(var1);
        bf = true;
        b(0.98F, 0.98F);
        height = length / 2.0F;
    }

    public EntityHyperkinesis(World var1, EntityHuman var2, int var3, int var4)
    {
        super(var1);
        player = var2;
        powerLevel = var3;
        cost = var4;
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        ticksInAir = 0;
        inGround = false;
        yawDir = (MathHelper.floor((double)(((var2.yaw + 180F) * 4F) / 360F) - 0.5D) & 3) + 1;
        b(0.5F, 0.5F);
        setPositionRotation(var2.locX, var2.locY + (double)var2.getHeadHeight(), var2.locZ, var2.yaw, var2.pitch);
        locX -= MathHelper.cos((yaw / 180F) * 3.141593F) * 0.16F;
        locY -= 0.10000000000000001D;
        locZ -= MathHelper.sin((yaw / 180F) * 3.141593F) * 0.16F;
        setPosition(locX, locY, locZ);
        length = 0.0F;
        be = 10D;
        motX = -MathHelper.sin((yaw / 180F) * 3.141593F) * MathHelper.cos((pitch / 180F) * 3.141593F);
        motZ = MathHelper.cos((yaw / 180F) * 3.141593F) * MathHelper.cos((pitch / 180F) * 3.141593F);
        motY = -MathHelper.sin((pitch / 180F) * 3.141593F);
        calcVelo(motX, motY, motZ, 1.991F, 1.0F);
    }

    public EntityHyperkinesis(World var1, double var2, double var4, double var6)
    {
        this(var1);
        setPosition(var2, var4, var6);
        ticksInAir = 0;
    }

    protected void b()
    {
    }

    public void calcVelo(double var1, double var3, double var5, float var7, 
            float var8)
    {
        float var9 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
        var1 /= var9;
        var3 /= var9;
        var5 /= var9;
        var1 *= var7;
        var3 *= var7;
        var5 *= var7;
        motX = var1;
        motY = var3;
        motZ = var5;
        float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
        lastYaw = yaw = (float)((Math.atan2(var1, var5) * 180D) / 3.1415926535897931D);
        lastPitch = pitch = (float)((Math.atan2(var3, var10) * 180D) / 3.1415926535897931D);
    }

    public void F_()
    {
        super.F_();
        if(!world.isStatic && (player == null || player.dead))
            die();
        if(inGround)
        {
            int var1 = world.getTypeId(xTile, yTile, zTile);
            if(var1 == inTile)
                return;
            inGround = false;
            motX *= random.nextFloat() * 0.2F;
            motY *= random.nextFloat() * 0.2F;
            motZ *= random.nextFloat() * 0.2F;
        } else
        {
            ticksInAir++;
        }
        float var16 = MathHelper.sqrt(motX * motX + motZ * motZ);
        yaw = (float)((Math.atan2(motX, motZ) * 180D) / 3.1415926535897931D);
        for(pitch = (float)((Math.atan2(motY, var16) * 180D) / 3.1415926535897931D); pitch - lastPitch < -180F; lastPitch -= 360F);
        for(; pitch - lastPitch >= 180F; lastPitch += 360F);
        for(; yaw - lastYaw < -180F; lastYaw -= 360F);
        for(; yaw - lastYaw >= 180F; lastYaw += 360F);
        pitch = lastPitch + (pitch - lastPitch) * 0.2F;
        yaw = lastYaw + (yaw - lastYaw) * 0.2F;
        if(h_())
        {
            for(int var2 = 0; var2 < 4; var2++)
            {
                float var3 = 0.25F;
                world.a("smoke", locX - motX * (double)var3, locY - motY * (double)var3, locZ - motZ * (double)var3, motX, motY, motZ);
            }

            world.makeSound(this, "random.fizz", 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
            die();
        }
        lastX = locX;
        lastY = locY;
        lastZ = locZ;
        locX += motX;
        locY += motY;
        locZ += motZ;
        setPosition(locX, locY, locZ);
        if(ticksInAir >= 3)
        {
            Vec3D var17 = Vec3D.create(locX, locY, locZ);
            Vec3D var18 = Vec3D.create(locX + motX, locY + motY, locZ + motZ);
            MovingObjectPosition var4 = world.rayTrace(var17, var18, grab);
            var17 = Vec3D.create(locX, locY, locZ);
            var18 = Vec3D.create(locX + motX, locY + motY, locZ + motZ);
            if(var4 != null)
                var18 = Vec3D.create(var4.pos.a, var4.pos.b, var4.pos.c);
            Entity var5 = null;
            List var6 = world.getEntities(this, boundingBox.a(motX, motY, motZ).grow(1.0D, 1.0D, 1.0D));
            double var7 = 0.0D;
            for(int var9 = 0; var9 < var6.size(); var9++)
            {
                Entity var10 = (Entity)var6.get(var9);
                if(var10.o_() && ticksInAir >= 2)
                {
                    float var11 = 0.3F;
                    AxisAlignedBB var12 = var10.boundingBox.grow(var11, var11, var11);
                    MovingObjectPosition var13 = var12.a(var17, var18);
                    if(var13 != null)
                    {
                        double var14 = var17.b(var13.pos);
                        if(var14 < var7 || var7 == 0.0D)
                        {
                            var5 = var10;
                            var7 = var14;
                        }
                    }
                }
            }

            if(var5 != null)
                var4 = new MovingObjectPosition(var5);
            if(var4 != null)
            {
                List var19 = world.a(player.getClass(), AxisAlignedBB.b(locX - (double)(2.0F + powerLevel), locY - (double)(2.0F + powerLevel), locZ - (double)(2.0F + powerLevel), locX + (double)(2.0F + powerLevel), locY + (double)(2.0F + powerLevel), locZ + (double)(2.0F + powerLevel)));
                if(var19.size() > 0)
                {
                    for(int var20 = 0; var20 < 4; var20++)
                    {
                        float var11 = 0.25F;
                        world.a("smoke", locX - motX * (double)var11, locY - motY * (double)var11, locZ - motZ * (double)var11, motX, motY, motZ);
                    }

                    world.makeSound(this, "random.fizz", 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
                    die();
                    return;
                }
                if(ConsumeReagent(true))
                    explode();
                die();
            }
        }
    }

    public boolean ConsumeReagent(boolean var1)
    {
        return EEProxy.isClient(world) ? false : EEBase.consumeKleinStarPoint(player, cost * 384) ? true : EEBase.Consume(new ItemStack(Item.GLOWSTONE_DUST, cost), player, var1) ? true : EEBase.Consume(new ItemStack(Item.SULPHUR, cost * 2), player, var1) ? true : EEBase.Consume(new ItemStack(Item.COAL, cost * 3, 0), player, var1) ? true : EEBase.Consume(new ItemStack(Item.REDSTONE, cost * 6), player, var1) ? true : EEBase.Consume(new ItemStack(Item.COAL, cost * 12, 1), player, var1);
    }

    private void explode()
    {
        float var1 = 1.0F + 2.0F * (powerLevel / 3F);
        newCombustion(player, locX, locY, locZ, var1);
    }

    public Combustion newCombustion(EntityHuman var1, double var2, double var4, double var6, 
            float var8)
    {
        Combustion var9 = new Combustion(world, var1, var2, var4, var6, var8);
        var9.doExplosionA();
        var9.doExplosionB(true);
        return var9;
    }

    public void b(NBTTagCompound nbttagcompound1)
    {
    }

    public void a(NBTTagCompound nbttagcompound1)
    {
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    private float powerLevel;
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int yawDir;
    private int cost;
    public static boolean grab = false;
    private boolean inGround;
    private EntityHuman player;
    private int ticksInAir;

}


/*
	DECOMPILATION REPORT

	Decompiled from: /home/dread/Downloads/EE2ServerV1.4.6.5-bukkit-mcpc-1.2.5-r5.zip
	Total time: 34 ms
	Jad reported messages/errors:
The class file version is 51.0 (only 45.3, 46.0 and 47.0 are supported)
	Exit status: 0
	Caught exceptions:
*/