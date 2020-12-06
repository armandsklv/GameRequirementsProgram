public class RecommendedRequirements extends GameRequirements
{
    public RecommendedRequirements(String amdCpu, String intelCpu, String AMDGpu, String intelGpu, int cpuCoreCount, double cpuClockSpeed, int ram, String os, double gpuVRAM, int diskSpace)
    {
        super(amdCpu, intelCpu, AMDGpu, intelGpu, cpuCoreCount, cpuClockSpeed, ram, os, gpuVRAM, diskSpace);
    }

    public void printRecommendedRequirements()
    {
        System.out.println("-----Recommended System requirements-----\n"+
                "CPU: "+this.getIntelCpu()+" or "+this.getAmdCpu()+"\n"+
                "RAM: "+this.getRam()+"GB\n"+
                "OS; "+this.getOs()+"\n"+
                "VIDEO CARD: "+this.getNvidiaGpu()+" or "+getAMDGpu()+"\n"+
                "FREE DISK SPACE: "+this.getDiskSpace()+"\n"+
                "DEDICATED VIDEO RAM: "+this.getGpuVRAM());
    }
}
